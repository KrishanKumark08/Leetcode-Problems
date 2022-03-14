class Solution {
    public String simplifyPath(String path) {
        ArrayList<String> dirList = new ArrayList<String>();
        int index = -1;
        boolean slash = false;
       
        String[] tokens = path.split("/");  
        
        for(int i = 0; i< tokens.length;i++){
            if(!tokens[i].equals("") && !tokens[i].equals(".")){
                if(tokens[i].equals("..")){
                    if(index >= 0){
                        dirList.remove(index);
                        index--;
                    }   
                    
                }
                else{
                    index++;
                    dirList.add(tokens[i]);
                }
                
                
            }

        }
        
        String[] arr = new String[dirList.size()];
        arr = dirList.toArray(arr);
         String  canPath 
            = "/" + String.join("/",arr);        
        return canPath;
    
    
    }
    
}