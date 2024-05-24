public class DinnerFullCource {
    private Dish[] list = new Dish[5];// [0]-[4]の計5個

    public DinnerFullCource() {
        for (int i = 0; i < 5; i++) {
            list[i] = new Dish();
        }
        list[0].setName("センター");
        list[1].setName("ペア");
        list[2].setName("アナザ");
        list[3].setName("ニュース");
        list[4].setName("GOD");

        list[0].setValune(10000);
        list[1].setValune(6000);
        list[2].setValune(7800);
        list[3].setValune(6900);
        list[4].setValune(10000);

    }

    public static void main(String[] args) {

        DinnerFullCource fullcourse = new DinnerFullCource();
        fullcourse.eatAll();

    }

    public String eatAll() {
        String kasu = "";
        for (Dish a : list) {
            System.out.println(a.getName());
            System.out.println(a.getValune());
            kasu = a.getName() + a.getValune();
        }
        return kasu;
    }

}
