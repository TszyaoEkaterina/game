public class NotRegisteredException extends RuntimeException{
    public NotRegisteredException(){
        super("One or two players are not registered.");
    }
}
