
public class main {
    public static void main(String[] args) {

//        HashMap<Integer,String> hashMap = new HashMap<>();
//        String resVal = hashMap.put(12,"AAA");
//        resVal = hashMap.put(12,"bbbbbb");

//        Employee employee1 = new Employee("AAA",123);
//        System.out.println(employee1.hashCode());
//        Employee employee2= new Employee("BB",45);
//        System.out.println(employee2.hashCode());
//
//        int[] array = new int[]{};

        HashMap<String,String> hashMap = new HashMap<>(4);
        String adResult = hashMap.put("+7923123412300","AAAAAAA");
        adResult = hashMap.put("+79231234123301","BBBBBBB");
        adResult = hashMap.put("+79231234123300","DDDDDDD");
        adResult = hashMap.put("+79231234123302","EEEEEEE1");
        adResult = hashMap.put("+79231234123303","EEEEEEE2");
        adResult = hashMap.put("+79231234123304","EEEEEEE3");
        adResult = hashMap.put("+79231234123305","EEEEEEE4");
        adResult = hashMap.put("+79231234123306","EEEEEEE5");
        adResult = hashMap.put("+79231234123307","EEEEEEE6");
        adResult = hashMap.put("+79231234123308","EEEEEEE7");
        adResult = hashMap.put("+79231234123309","EEEEEEE8");
        adResult = hashMap.put("+79231234123310","EEEEEEE9");


        System.out.println(hashMap.get("+79231234123304"));
        System.out.println(hashMap);





    }
}
