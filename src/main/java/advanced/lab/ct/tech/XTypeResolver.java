package advanced.lab.ct.tech;

public interface XTypeResolver<X> {

    <A extends X> A resolveXType();
}
