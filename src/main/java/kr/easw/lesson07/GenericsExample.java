package kr.easw.lesson07;


/**
 * �ش� Ŭ������ �͸� Ŭ���� �� ���ʸ����� ���� ���� �� ģ�������� ���� ������ �����Դϴ�.
 *
 * �ּ��� �о� �ڵ带 �����ϰ�, �ڵ尡 ���������� �����ϵ��� �����غ�����.
 * �ش� �ڵ�� �ǵ������� ������ �߻��ϵ��� �����Ǿ����ϴ�.
 */
public class
GenericsExample {

    public static void main(String[] args) {
        Recipe<Ingredient, Cake> recipe = new Recipe<>(new Egg()) {
            @Override
            public Cake cook() {
                // ���ʸ����� ���� Ŭ������ Ȯ����������, T ���ʸ����� Ingredient�� ��ӹ޴°��� ����˴ϴ�.
                // �׷��Ƿ�, ������� ȣ���� �� ���� Ingredient�� mix() �޼��带 ȣ���� �� �ְ� �˴ϴ�.
                getIngredient().mix();
                return new Cake();
            }
        };
        // ��ȯ�� ���� �����ϴ�. ���ʸ����� ���� Ŭ������ Ȯ����������, R ���ʸ����� Cake�̰ų� Cake Ŭ������ ��ӹ��� Ŭ�������� ����˴ϴ�.
        recipe.cook().bake();
    }

    // ���ʸ����� Ŭ������ �޼��带 ������ ��, Ÿ���� �Ķ���ͷ� ����� �� �ְԲ� �ϴ� ����Դϴ�.
    // ���� ���, �� Ŭ���������� T�� ��� Ŭ������, R�� ��ȯ Ŭ������ ����ϰ� �ֽ��ϴ�. �ٸ�, �� Ŭ���������� ���ʸ����� Ȯ������ �ʾ������� Ŭ������ �����ϱ� �������� T�� R�� �������� �� �� �����ϴ�.
    // ���� main �޼��带 ����, Recipe ���� ���� �ȿ� 2���� Ŭ���� �̸��� �����ֽ��ϴ�. �̰��� ���ʸ����� Ȯ���Դϴ�.
    // �̸� ����, Recipe Ŭ������ Ingredient Ŭ������ ����, Cake Ŭ������ ��ȯ������ ����ϰ� �˴ϴ�.
    abstract static class Recipe<T, R> {
        // ���ʸ����� ����Ͽ� ��Ḧ ������ �� �ְԲ� �մϴ�.
        private final T ingredient;

        public Recipe(T ingredient) {
            this.ingredient = ingredient;
        }

        public T getIngredient() {
            return ingredient;
        }

        // ���ʸ����� ������ R Ŭ������ ��ȯ������ ����մϴ�.
        public abstract R cook();
    }

    // ���ʸ����� �ڹ��� �������� �����Ҷ� �߿��� ������ �����մϴ�.
    // ���ʸ��� ��ü�δ� ��Ÿ�ӻ󿡼� Ÿ���� �� �� ������, ������ Ÿ�ӿ� Ÿ���� �� �� �ְԲ� ���ݴϴ�.
    // �̷ν�, �Ķ���� �� ��ȯ Ÿ�Կ� �������� Ÿ���� ������ �� �ֱ⿡ �ڵ��� �������� ���� �� �ֽ��ϴ�.
    interface Ingredient {
        void mix();
    }

    static class Flour implements Ingredient {
        @Override
        public void mix() {
            System.out.println("Mixing flour...");
        }
    }

    static class RottenEgg implements Ingredient {
        @Override
        public void mix() {
            throw new RuntimeException("Rotten egg detected!");
        }
    }

    static class Egg implements Ingredient {
        @Override
        public void mix() {
            System.out.println("Mixing egg...");
        }
    }

    static class Cake {
        public void bake() {
            System.out.println("Done!");
        }
    }



}
