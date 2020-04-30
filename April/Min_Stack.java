/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
*/
class MinStack {
    ArrayList<Integer> a;
    public MinStack() {
      a=new ArrayList<Integer>();  
    }
    
    public void push(int x) {
        a.add(x);
    }
    
    public void pop() {
        a.remove(a.size()-1);
    }
    
    public int top() {
       return a.get(a.size()-1);
    }
    
    public int getMin() {
        //return Collections.min(a);
        int min = a.get(0);
        for (int i = 1; i < a.size(); i++) {
          int n = a.get(i);
            if (n<min) 
                min = n;
        }
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
