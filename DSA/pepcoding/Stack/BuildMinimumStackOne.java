import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BuildMinimumStackOne {
    private int[] data;
    private int tos;
    private int[] minData;
    private int min;

    BuildMinimumStackOne(int n) {
        data = new int[n];
        tos = -1;
        minData = new int[n + 1];
        min = 0; 
        minData[0] = Integer.MAX_VALUE;
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
            System.out.println("Stack Overflow");
        } else  {
            tos++;
            if(val < minData[min])  {
                min++;
                minData[min] = val;
            }
            data[tos] = val;
        }  
    }

    private int pop() {
        if(tos == -1)  {
            System.out.println("Stack Underflow");
            return -1;
        }
        else  {
            int val = data[tos];
            tos--;
            if(val == minData[min])  min--;
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

    private int min()  {
        if(min == 0)  {
            System.out.println("Stack Underflow");
            return -1;
        } else  {
            return minData[min];
        }    
    }  

    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        BuildMinimumStackOne st = new BuildMinimumStackOne(n);

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
            } else if (str.startsWith("min")) {
                int val = st.min();
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
