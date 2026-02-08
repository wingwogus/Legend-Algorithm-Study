#include <iostream>
#include <vector>

using namespace std;
int n;
vector<int> deck;
vector<int> dp;
void input() {
    cin >> n; // 구매할 카드 갯수
    // DP에 뭘 저장할 건지를 먼저 정하는 게 좋음
    // 문제에서 원하는 건 카드 N개를 갖기 위해 지불해야되는 금액의 최솟값
    // 금액을 저장해보는 식으로 생각해보자
    deck.push_back(0); // 인덱스와 팩 번호 맞추기 위함
    for (int i = 0; i < n; i++) {
        int pack;

        cin >> pack;
        deck.push_back(pack);
    }
}
void draw(){
    // 배낭 문제와 같은 것 같음
    dp.assign(n+1, 0); //


}
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    input();
    draw();
    return 0;
}
