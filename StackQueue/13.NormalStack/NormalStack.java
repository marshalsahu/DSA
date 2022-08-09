public class NormalStack {

    public static class NStack{
        int[] data;
        int tos;

        NStack(int cap){
            data = new int[cap];
            tos = -1;
        }

        public int size(){
            return tos+1;
        }

        // public void push(int val){

        //     if(tos + 1 >= data.length){
        //         System.out.println("Overflow");
        //     }else{
        //         tos++;
        //         data[tos] = val;    
        //     }
        // }

        //dynamic push
        public void push(int val){

            if(tos == data.length - 1){
                int[] ndata = new int[2 * data.length ];
                for(int i = 0; i < data.length; i++){
                    ndata[i] = data[i];
                }
                data = ndata;
                tos++;
                data[tos] = val;
                
            }else{
                tos++;
                data[tos] = val;    
            }
        }

        public void display(){
            System.out.println("display start");
            for(int i=tos; i>=0; i--){
                System.out.print(data[i]+" ");
            }
            System.out.println("display finished");
        }

        public int pop(){
            if( tos < 0){
                System.out.println("pop underflow");
                return -1;
            }else {
                int rdata = data[tos];
                tos--;
                return rdata;
            }
        }

        public int top(){
            if ( tos == -1){
                System.out.println("top underflow");
                return -1;
            }else{
                return data[tos];
            }
        }
    }
    
    public static void main(String[] args) {
        NStack s = new NStack(10);
        s.push(10);
        s.push(20);
        s.display();
        System.out.println(s.top());
        s.pop();
        s.pop();
        System.out.println(s.top());
        s.display();
    }
}
