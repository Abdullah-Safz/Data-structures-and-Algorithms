public class array {

    public void arrayDemo(){
        int[] MyArray = new int[5];
        MyArray[0] = 2;
        MyArray[1] = 5;
        MyArray[2] = 22;
        MyArray[3] = 24;
        MyArray[4] = 52;
        for (int num :MyArray){
            System.out.print( num + ", ");
        }
        System.out.println("Abdullah");
    }

    public static void printArray(int[] arr){
        int n = arr.length;
        for(int i= 0 ; i < n ; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int[] EvenNumberRemover(int[] arr){
        int oddnum = 0 ;
        int n = arr.length ;
        for(int i =0; i<n ; i++){
            if(arr[i]%2 != 0){
                oddnum++;
            }
        }

        int[] OddNumber = new int[oddnum];
        int idx = 0;
        for(int i =0 ; i < n; i++){
            if(arr[i] %2 != 0){
                OddNumber[idx] = arr[i];
                idx++ ;
            }
        }
        return OddNumber;

    }

    public static void reverseArray(int[] number , int start , int end){
        while(start < end){
            int temp = number[start];
            number[start] = number[end];
            number[end]= temp;
            start++;
            end--;

        }

    }

    public static int findMininimum(int array[]){

        if(array == null || array.length == 0){
            throw new IllegalArgumentException("invalid input bro");
        }
        int min = array[0];
        for(int i = 1 ; i < array.length ; i++){
            if(array[i] < min){
                min = array[i];
            }
        }
        return  min;

    }

    public  static  int findsecondmax(int[] array){
        int max = Integer.MIN_VALUE;
        int secondmax = Integer.MIN_VALUE;
        for( int i = 0 ; i < array.length ; i++){
            if(array[i] > max){
                secondmax = max ;
                max = array[i];

            } else if (array[i]> secondmax && array[i ] != max) {
                secondmax = array[i];

            }
        }
        return secondmax ;
    }

    public static void movezeros(int[] arr){
        int j = 0 ;
        int n = arr.length;

        for(int i = 0 ; i < n ; i++ ){
            if(arr[i] != 0 && arr[j] == 0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            if(arr[j] != 0){
                j++ ;
            }
        }
    }

    /// resizing an array
    public static int[] resize( int[] arr , int capacity){
        int[] temp = new int[capacity];
        for(int i = 0 ; i < arr.length ; i++){
            temp[i] = arr[i];
        }
       return temp;
    }
    ///////

    public static int findmissingnumber(int[] arr){
        int n = arr.length + 1 ;
        int num = n*(n+1)/2;
        for(int i = 0 ; i < arr.length ; i++){
            num = num - arr[i];
        }
        return num ;

    }

    public static boolean checkpalindrome(String word){
        String normalized = word.toLowerCase();// to make it not case sensitive
        char[] charArray = normalized.toCharArray();
        int start = 0;
        int end = normalized.length() - 1 ;
        while (start < end){
            if (charArray[start] != charArray[end]){
                return false;
            }
            start++;
            end--;
        }
        return  true;
    }

    public static void main(String[] args){
        //int arr[] = {1,2,4,5};
        //int arr[] = {};

        System.out.println(checkpalindrome("MaDAM"));

    }
}
