#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

vector<int> dp; // index -> 날 값 -> 떡 갯수

int d, k;
bool do_dp(){
    for(int i = d-1; i>=2; i--){
        dp[i-1] = dp[i+1] - dp[i];
        if(dp[i]<dp[i-1]){
            return false;
        }
    }
    int min_ = *min_element(dp.begin()+1,dp.end());
    if( min_ <= 0 ){
        return false;
    }
    return true;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cin >> d >> k;
    dp.assign(d + 1, 0);

    dp[d] = k;
    // dp[d] = dp[d-1] + dp[d-2];
    // dp[d-2] = dp[d] - dp[d-1];
    // 결궁에 d-1일 일 때를 정하고 돌려야돼

    for(int s=1; k/2+s < k; s++){
        dp[d-1] = k/2 + s;
        if(do_dp()){
            break;
        }
        fill(dp.begin(),dp.end()-1,0); //초기화
    }

    cout << dp[1] << '\n' << dp[2]; // 첫째날 둘째 날.

    return 0;
}
