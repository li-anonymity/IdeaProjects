package Structural.Decorator;

public class TestStarbuzzCoffee {
    /**
     *区别于Shape，Beverage采用抽象类
     *通常装饰者模式是采用抽象类，但是在Java中可以使用接口
     */
    public static abstract class Beverage {
        public String description = "Unknown Beverage";

        public String getDescription() {
            return description;
        }

        public abstract double cost();
    }

    /**
     *被装饰类继承Beverage抽象类，最终会通过装饰者动态添加上新的行为
     */
    public static class DarkRoast extends Beverage {

        public DarkRoast() {
            description = "DarkRoast";
        }

        @Override
        public double cost() {
            return 0.99;
        }
    }

    /**
     *这是继承Beverage的抽象装饰者，接下来所有具体的装饰者都要继承CondimentDecorator
     */
    public static abstract class CondimentDecorator extends Beverage {

        /**
         *所有的调料装饰者都必须重新实现该方法，因为调料的该方法应该得到扩充，方法实现不同于原来方法
         */
        public abstract String getDescription();

    }

    /**
     *摩卡，是具体的装饰者
     *用一个实例变量记录饮料（被装饰者）
     *装饰者和被装饰者通过组合来增强功能，实现功能的扩展，用组合来替代继承
     */
    public static class Mocha extends CondimentDecorator {
        Beverage beverage;

        public Mocha(Beverage beverage) {
            this.beverage = beverage;
        }

        @Override
        public String getDescription() {
            return beverage.getDescription() + ", Mocha";
        }

        @Override
        public double cost() {
            return 0.20 + beverage.cost();
        }
    }

    public static void main(String[] args) {
        Beverage beverage1 = new DarkRoast();
        beverage1 = new Mocha(beverage1);
        beverage1 = new Mocha(beverage1);
        System.out.println(beverage1.getDescription()+ " $" + beverage1.cost());
    }
}
