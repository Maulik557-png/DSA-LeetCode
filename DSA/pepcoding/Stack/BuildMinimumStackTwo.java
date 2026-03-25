import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BuildMinimumStackTwo {
    private int[] data;
    private int tos;
    private int min;

    BuildMinimumStackTwo(int n) {
        data = new int[n];
        tos = -1;
    }

    private int size() {
        return tos + 1;
    }

    private void display() {
        int temp = min;
        for(int i = tos; i > -1; i--)   {
            // if(data[i] < min)  System.out.println(min);
            // else  System.out.println(data[i]);
            if(data[tos] < temp)  {
                int val = temp;
                temp = temp - data[i] + temp;
                System.out.println(val);
            } else  {
                System.out.println(data[i]);
            }
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
        if(tos == -1)  {
            min = val;
            tos++;
            data[tos] = val;
        } else if(val > min)  {
            tos++;
            data[tos] = val;
        } else  {
            tos++;
            data[tos] = val + val - min;  // mock the value and store it in stack, in order to get min value
            min = val;  // original value in min
        }
    }

    private int pop() {
        if(tos == -1)  {
            System.out.println("Stack Underflow");
            return -1;
        } else if(data[tos] < min)  {
            int val = min;
            min = min - data[tos] + min;
            tos--;
            return val;
        } else  {
            int val = data[tos];
            tos--;
            return val;
        }
    }
    
    private int peek() {
        if(tos == -1)  {
            System.out.println("Stack Underflow");
            return -1;
        } else if(data[tos] < min)  {
            return min;
        } else  {
            return data[tos];
        }  
    }

    private int min()  {
        if(tos == -1)  {
            System.out.println("Stack Underflow");
            return -1;
        } else  {
            return min;
        }    
    } 

    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        BuildMinimumStackTwo st = new BuildMinimumStackTwo(n);

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