package vehicles.interfaces;

public interface IMove {
    void go(int kms);

    default void startEngine(){
        System.out.println("Engine started");
    }
}
