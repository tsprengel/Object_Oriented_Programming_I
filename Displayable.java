public interface Displayable {
    default void print(){
        System.out.println(toString());
    }
}
