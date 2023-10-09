public class HashMap<K, V> {

    public String toString(){

       StringBuilder stringBuilder = new StringBuilder();
//
//        for (int i = 0; i < buckets.length; i++) {
//            stringBuilder.append(buckets.toString());
//        }
        //return stringBuilder.toString();
        for (int i = 2; i < buckets.length; i++) {
            if (buckets[i] == null) {
                continue;
            }
            Bucket bucket = buckets[i];
            stringBuilder.append(bucket.striGester());

        }
        return stringBuilder.toString();
    }

    //region Публичные методы

    public V put(K key, V value) {
        if (buckets.length * LOAD_FACTOR <= size) {
            recalculate();
        }


        int index = calculateBucketIndex(key);
        Bucket bucket = buckets[index];
        if (bucket == null) {
            bucket = new Bucket();
            buckets[index] = bucket;
        }
        Entity entity = new Entity();
        entity.key = key;
        entity.value = value;

        V buf = (V) bucket.add(entity);
        if (buf == null) {
            size++;
        }
        return buf;

    }

    public V get(K key) {
        int index = calculateBucketIndex((key));
        Bucket bucket = buckets[index];
        if (bucket == null) {
            return null;
        }
        return (V) bucket.get(key);
    }

    /**
     *
     * @param key
     * @return
     */
    public V remove(K key) {
        int index = calculateBucketIndex((key));
        Bucket bucket = buckets[index];
        if (bucket == null) {
            return null;
        }
        V buf = (V)bucket.remove(key);
        if (buf != null) {
            size--;
        }
        return buf;
    }

    //endregion

    //region Методы

    private int calculateBucketIndex(K key) {
        return Math.abs(key.hashCode()) % buckets.length;
    }

    private void recalculate() {
        size = 0;
        Bucket<K, V>[] old = buckets;
        buckets = new Bucket[old.length * 2];
        for (int i = 0; i < old.length; i++) {
            Bucket<K, V> bucket = old[i];
            if (bucket == null) {
                continue;
            }
            Bucket.Node node = bucket.head;
            while (node != null) {
                put((K) node.value.key, (V) node.value.value);
                node = node.next;
            }

        }

    }
    //endregion

    //region Конструктор
    public HashMap() {
        buckets = new Bucket[INIT_BUCKET_COUNT];
    }

    public HashMap(int capacity) {
        buckets = new Bucket[capacity];
    }
    //endregion

    //region Константа
    private static final int INIT_BUCKET_COUNT = 16;

    private static final double LOAD_FACTOR = 0.5;

    //endregion

    //region Поля
    private Bucket[] buckets;

    private int size;

    //endregion


    //region Вспомогательная структуры
    class Entity {
        K key;

        V value;

    }

    class Bucket<K, Y> {
        private Node head;

        class Node {

            Node next;

            Entity value;


        }

        public V add(Entity entity) {
            Node node = new Node();
            node.value = entity;
            if (head == null) {
                head = node;
                return null;
            }
            Node currentNBode = head;
            while (true) {
                if (currentNBode.value.key.equals(entity.key)) {
                    V buf = currentNBode.value.value;
                    currentNBode.value.value = entity.value;
                    return buf;
                }
                if (currentNBode.next != null) {
                    currentNBode = currentNBode.next;
                } else {
                    currentNBode.next = node;
                    return null;
                }

            }
        }

        public V get(K key) {
            Node node = head;
            while (node != null) {
                if (node.value.key.equals(key)) {
                    return (V) node.value.value;
                }
                node = node.next;
            }
            return null;
        }

        public V remove(K key) {
            if (head == null) {
                return null;
            }
            if (head.value.key.equals(key)) {
                V buf = (V) head.value.value;
                head = head.next;
                return buf;
            } else {
                Node node = head;
                while (node.next != null) {
                    if (node.next.value.key.equals(key)){
                        V buf = (V)node.next.value.value;
                        node.next = node.next.next;
                        return buf;
                    }
                    node = node.next;
                }
                return null;
            }

        }

        public String striGester(){
            if (head == null) {
                return null;
            }
            StringBuilder stringBuilder = new StringBuilder();

            Node node = head;
            while (node != null) {
                stringBuilder.append("Keys - " + node.value.key);
                stringBuilder.append("\n");
                stringBuilder.append("Value - " + node.value.value);
                stringBuilder.append("\n");
                node = node.next;
            }
            return stringBuilder.toString();



        }

    }


    //endregion
}
