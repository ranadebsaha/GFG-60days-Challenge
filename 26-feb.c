//Isomorphic Strings
#include <stdbool.h>
#include <string.h>

bool areIsomorphic(char *s1, char *s2) {

    char map1[256] ={0}; 
    char map2[256] ={0};
    
    for (int i = 0; s1[i] !='\0'; i++) {
        unsigned char c1 =s1[i];
        unsigned char c2 = s2[i];
        
        if (map1[c1] != 0 && map1[c1] != c2) {
            return false;
        }

        if (map2[c2] != 0 && map2[c2] != c1) {
            return false;
        }
        
        map1[c1] = c2;
        map2[c2] = c1;
    }
    
    return true;
}
