class Solution {
    public boolean parseBoolExpr(String expression) {
        if(expression.length()==1){
            if(expression.charAt(0)=='t')
                return true;
            return false;
        }
        return recursion(expression,0,expression.length());
    }
    boolean recursion(String exp,int startIndex, int endIndex){
        if(startIndex>endIndex)
            return false;
        boolean result=false;
        if(exp.charAt(startIndex)=='t' || exp.charAt(startIndex)=='f')
            return exp.charAt(startIndex)=='t'?true:false;
        if(exp.charAt(startIndex)=='!'){
            boolean tempResult=!recursion(exp,startIndex+2,endIndex-1);
            return tempResult;
        }
        
        if(exp.charAt(startIndex)=='&' || exp.charAt(startIndex)=='|'){
            Map<Integer,Integer> map=new HashMap<>();
            int open=0;
            int close=0;
            for(int i=startIndex+2;i<endIndex-1;i++){
                if(exp.charAt(i)=='(')
                    open++;
                if(exp.charAt(i)==')')
                    close++;
            }
            for(int i=startIndex+2;i<endIndex-1;i++){
                if(exp.charAt(i)==')')
                    close--;
                map.put(i,open-close);
                if(exp.charAt(i)=='(')
                    open--;
            }
            if(exp.charAt(startIndex)=='&')
                result=true;
            for(int i=startIndex+2;i<endIndex-1;i++){
                if(exp.charAt(i)=='t' || exp.charAt(i)=='f'){
                    if(map.get(i)==0){
                        if(exp.charAt(startIndex)=='&')
                            result= result && exp.charAt(i)=='t'?true:false;
                        else if(exp.charAt(startIndex)=='|'){
                            result= result || exp.charAt(i)=='t'?true:false;   
                            System.out.println(result+" "+exp.charAt(i));
                        }
                    }
                }
                if(exp.charAt(i)=='&' || exp.charAt(i)=='|' || exp.charAt(i)=='!'){
                    int index=0;
                    for(int j=i;j<endIndex-1;j++){
                        if(exp.charAt(j)==')' && map.get(j)==map.get(i) ){
                            index=j;
                            break;
                        }
                    }
                    if(exp.charAt(startIndex)=='&')
                        result=  result && recursion(exp,i,index+1);
                    else if(exp.charAt(startIndex)=='|')
                        result= result || recursion(exp,i,index+1);
                    i=index+1;
                }
                
            }
        }
        return result;
        
    }
}