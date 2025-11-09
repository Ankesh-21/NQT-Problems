#include<bits/stdc++.h>
using namespace std;

bool isPalindrome(int n){
    int reversed = 0;
    int original = n;
    while (n > 0){
        int digit = n % 10;
        reversed = reversed * 10 + digit;
        n /= 10;
    }

    if (reversed == original){
        return true;
    }
    return false;

}

int main(){
    int n;
    cin >> n;
    int cnt = 0;
    for(int i = 10;i <= 100;i++){
        if (isPalindrome(i)){
            cnt += 1;
        }
    }
    cout << cnt << endl;
}