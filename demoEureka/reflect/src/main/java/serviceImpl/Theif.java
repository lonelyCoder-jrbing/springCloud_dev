package serviceImpl;

import service.StealMethod;

public class Theif {
    private StealMethod method;

    public Theif(StealMethod method) {
        this.method = method;
    }


    public void changMethod(StealMethod method){
        this.method = method;
    }
    public void steal(){
        this.method.steal();
    }
}
