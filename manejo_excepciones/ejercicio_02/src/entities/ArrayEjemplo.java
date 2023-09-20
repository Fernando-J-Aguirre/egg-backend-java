package entities;

public class ArrayEjemplo {

    private int[] array;

    public ArrayEjemplo() {
    }

    public ArrayEjemplo(int tamanio) {
        this.array = new int[tamanio];
    }

    public void setArray(int i, int num) {
        try {
            this.array[i] = num;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("CATCH ArrayIndexOutOfBoundsException");
            System.out.println(e);
        } 
    }

    public void setArray2(int i, int num) throws ArrayIndexOutOfBoundsException{ //no es necesario el throws (unchecked exception)
        if(i <= array.length) {            
            this.array[i] = num;
        } else {
            throw new ArrayIndexOutOfBoundsException("SET ARRAY 2 - ArrayIndexOutOfBoundsException");
        }
    }

}
