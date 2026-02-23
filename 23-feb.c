int* findUnion(int* a, int n, int* b, int m, int* returnSize) {
    // code here
    int size;
    if(max(a,n)>=max(b,m)){
        size=max(a,n);
    }else{
        size=max(b,m);
    }
    long freq[size+1];
    for(int i=0;i<=size;i++){
        freq[i]=0;
    }
    for(int i=0;i<n;i++){
        if(freq[a[i]]==1){
            continue;
        }else{
            freq[a[i]]=1;
        }
    }
    for(int i=0;i<m;i++){
        if(freq[b[i]]==1){
            continue;
        }else{
            freq[b[i]]=1;
        }
    }
    int count = 0;
    for (int i = 0; i <= size; i++) {
        if (freq[i] == 1) {
            count++;
        }
    }
    int* result = (int*)malloc(count * sizeof(int));
    int index = 0;
    
    for (int i = 0; i <= size; i++) {
        if (freq[i] == 1) {
            result[index++] = i;
        }
    }
    *returnSize=count;
   return result;
}

int max(int* a,int n){
    int max=a[0];
    for(int i=1;i<n;i++){
        if(max<a[i]){
            max=a[i];
        }
    }
    return max;
    
}
