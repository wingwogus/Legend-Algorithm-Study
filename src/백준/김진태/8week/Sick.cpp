#include <iostream>
#include <algorithm>

using namespace std;

long long n,m; // 체스 가로 세로 길이

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> n >> m; // n과 m이 굉장히 큼

    if(n == 1){ // 세로가 1이면
        // 못 움직임
        cout << 1 << '\n';
    }
    else if(n == 2){ // 세로가 2면
        // M이 충분하다면? 4가지 방법을 전부 쓰진 못함.
        if(m <=2){
            cout << 1 << '\n'; // 또한 못움직임
        }else if(m <=6){
            cout << (m+1) / 2 << '\n';
        }else{
            cout << 4 << '\n';
        }
    }else{ // n 이 3보다 크거나 같다면
        // M이 충분할 경우 4가지 전부 사용해서 갈 수 있음.
        if(m <= 3){ // n과 마찬가지로 m이 1이면 이동할 수가 없음
            cout << m << '\n';
        }
        else if(m =7){
            cout << min(4LL,m)<<'\n';
        }
        else{ // m이 3이상이라면?
            cout << m -2 << '\n';
        }
    }

    return 0;
}