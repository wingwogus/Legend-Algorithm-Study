#include <iostream>
#include <vector>
using namespace std;

int testcase,n,m; // 테스트 케이스, 서, 동
vector<vector<long long>> temp(31, vector<long long>(31, -1));

long long bridge_dp(int n, int m){
    if(n == 0) return 1; // 다 놓았으면 성공 1회
    if(m == 0) return 0; // 다 못놓았는데 자리가 없으면 실패

    // 이미 계산한적 있는지 확인
    if(temp[n][m] != -1) return temp[n][m];

    temp[n][m] = bridge_dp(n-1,m-1) + bridge_dp(n,m -1);

    return temp[n][m];
}
void input(){

    cin >> testcase;

    for(int i=0; i<testcase; i++){
        cin >> n >> m;
        cout << bridge_dp(n,m) << '\n';
    }

}
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    input();

    return 0;
}