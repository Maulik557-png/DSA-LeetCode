import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BuildDynamicStack {
    private int[] data;
    private int tos;

    BuildDynamicStack(int n) {
        data = new int[n];
        tos = -1;
    }

    private int size() {
        return tos + 1;
    }

    private void display() {
        for(int i = tos; i > -1; i--)   {
            System.out.println(data[i]);
        }
    }
    
    private void push(int val) {
        if(tos == data.length - 1)  {
            int[] temp = new int[2 * data.length];
            for(int i = 0; i < data.length; i++)   {
                temp[i] = data[i];
            }
            data = temp;
        }
        tos++;
        data[tos] = val;
    }

    private int pop() {
        if(tos == -1)  {
            System.out.println("Stack Underflow");
            return -1;
        }
        else  {
            int val = data[tos];
            tos--;
            return val;
        }
    }
    
    private int peek() {
        if(tos == -1)  {
            System.out.println("Stack Underflow");
            return -1;
        } else  {
            return data[tos];
        }  
    }
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        BuildDynamicStack st = new BuildDynamicStack(n);

        String str = br.readLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("push")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                st.push(val);
            } else if (str.startsWith("pop")) {
                int val = st.pop();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("peek")) {
                int val = st.peek();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("size")) {
                System.out.println(st.size());
            } else if (str.startsWith("display")) {
                st.display();
            }
            str = br.readLine();
        }
    }
}
