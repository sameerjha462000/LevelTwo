    /**
     * Classic example of acquire-release strategy
     **/
    private static void run(int[] nums,int k){
        HashMap<Integer,Integer> map = new HashMap<>();


        for(int i = 0; i < k-1;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        int acquired = k - 1;

        int released = 0;

        while(acquired != nums.length){

            /**
             * when we enter into the loop each time, |windowSize| = k-1.
             **/

            map.put(nums[acquired],map.getOrDefault(nums[acquired],0)+1);
            
            /**
             * Now window size has become k, so print the size of the hashmap
             **/

            System.out.print(map.size()+" ");

            /**
             * Now since |windowSize| = k, so we must do released++.
             * In doing so, the element at released position might get removed or it's frequency might be decreased.
             **/

            int val = nums[released];

            if(map.get(val) == 1){
                /**
                 * If freq is 1, then completely remove the element,no need to make freq == 0
                 **/
                map.remove(val);
            }else{
                /**
                 * If freq > 1, then reduce the freq by 1.
                 **/
                map.put(val,map.get(val)-1);
            }

            acquired++;
            released++;
        }

    }



    // 1. You are given an array(arr) of integers and a number K.

    // 2. You have to find the count of distinct numbers in all windows of size k.
    // Constraints

    // 1 <= N <= 10^5

    // 1 <= arr[i] <= 10^4

    // 1 <= k <= N


    // Sample Input

    // 7

    // 1 2 1 3 4 2 3        

    // 4
    // Sample Output

    // 3 4 4 3 