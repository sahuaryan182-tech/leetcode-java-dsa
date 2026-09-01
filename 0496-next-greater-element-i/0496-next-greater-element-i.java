class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums2.length;
        int[] nge = new int[n];
        Stack<Integer> st = new Stack<>();
        
        //now start tarvesing form the back
        for(int i = n-1; i>=0; i--){

            //pop all smaller element form the stack, we store decrsing order form in  the stack
            //trevaer becuse we pop many times , and do same repetitave work
            while(!st.isEmpty() && st.peek() <= nums2[i]){
                //the pop element till n element
                st.pop();

            } //remove larger element whose larger then  nge[i]
            //if stack is empty , means put -1 as ans, no NGE exist
            if(st.isEmpty())  nge[i] = -1;

            //remove the larger element the nge[i] in stack and put it into a nge arr 
            else{
               nge[i] =  st.peek();
            }


            //insert or add the value in stcak
            st.push(nums2[i]);
        }
        //map each value in num2 -> its extct grater value
        HashMap<Integer, Integer> ans = new HashMap<>();
        for(int i = 0; i<nums2.length; i++){
            ans.put(nums2[i], nge[i]);
            
        }
        
        //build anware for num1 by using the map
        int[] result = new int[nums1.length];
        for(int i = 0; i<nums1.length; i++){
            result[i] = ans.get(nums1[i]); //nums2 key jo map mein put hai or as a key elemnt and nums1 ka key element match kara to get value of nge[i] us key 
        }
        return result;

        
    }
}