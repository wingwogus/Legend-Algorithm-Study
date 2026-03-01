#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int n;
vector<int> arr;
vector<int> temp; // 기록용 벡터
void input(){
    cin >> n;

    for(int i=0; i<n; i++){
        int v;
        cin >> v;
        arr.push_back(v);
    } // 수열 완성
}
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    input();

    for(int k=0; k<n; k++){
        int value = arr[k];
        if(temp.empty()|| value > temp.back()){
            // temp가 비었거나 이번 값이 temp의 가장 큰 값보다 크다면
            temp.push_back(value);
        }else{ // 가장 큰 값보다 크지 않는다는건 -> 자리를 찾아야됨.
            // value보다 크거나 같은 놈의 위치(주소)를 찾아서
            auto lterator = lower_bound(temp.begin(), temp.end(), value);

            *lterator = value; // 갈아끼움
        }
    }
    cout << temp.size() << '\n';
    return 0;
}