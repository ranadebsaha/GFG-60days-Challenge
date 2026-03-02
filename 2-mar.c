//Trapping Rain Water
#include <stdlib.h>

#define MAX(a, b) ((a) > (b) ? (a) : (b))
#define MIN(a, b) ((a) < (b) ? (a) : (b))

int maxWater(int* arr, int n) {
    
    if (n <= 2) return 0; 

    int* prefix = (int*)malloc(n * sizeof(int));
    int* suffix = (int*)malloc(n * sizeof(int));

    prefix[0] = arr[0];
    for (int i = 1; i < n; i++) {
        prefix[i] = MAX(prefix[i-1], arr[i]);
    }

    suffix[n-1] = arr[n-1];
    for (int i = n - 2; i >= 0; i--) {
        suffix[i] = MAX(arr[i], suffix[i+1]);
    }

    int total = 0;
    
    for (int i = 0; i < n; i++) {
        int leftmax = prefix[i];
        int rightmax = suffix[i];
        
        if (arr[i] < leftmax && arr[i] < rightmax) {
            total += MIN(leftmax, rightmax) - arr[i];
        }
    }

    
    free(prefix);
    free(suffix);

    return total;
}
