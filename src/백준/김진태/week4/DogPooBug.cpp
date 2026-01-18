#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int n, h;
vector<int> top; // 상단
vector<int> bottom; // 하단
vector<int> faced; //

void input() {
    cin >> n >> h;; // N은 동굴의 가로길이 h는 세로 길이

    for (int i = 0; i < n; i++) {
        int obs_h;

        cin >> obs_h;

        if (i % 2 == 0 || i == 0) {
            // 홀수 -> 하단(엔덱스로는 짝수)
            bottom.push_back(obs_h);
        } else {
            // 상단 -> 짝수 (인덱스로는 홀수)
            top.push_back(obs_h);
        }
    }
}

// 층마다 장애물을 몇번 파괴해야되는지
int is_faced(int layer) {
    // 이때 layer는 층임 0 -> 1층
    int top_cnt = 0;
    int bottom_cnt = 0;

    int start = 0;
    int top_end = top.size() - 1;
    int bottom_end = bottom.size() - 1;

    int t_i = top.size(); // 찾을 인덱스
    int b_i = bottom.size(); // 초기 설정을 끝 값으로
        // top과 bottom은 정렬되어있는 상태임
    while (start <= top_end) {
        //layer > h-top[i]
        int mid = (start + top_end) / 2; // 중간
        if (layer >= h - top[mid]) { //
            t_i = mid;
            top_end = mid - 1;
        } else {
            start = mid + 1;
        }
    }
    // t_i를 top.size() 끝 값으로 설정해서 부딪히지 않았을 때를 처리할 수 있음
    top_cnt = top.size() - t_i;

    start = 0;
    while (start <= bottom_end) {
        //layer <= bottom[i])
        int mid = (start + bottom_end) / 2; // 중간
        if (layer < bottom[mid]) { //
            b_i = mid;
            bottom_end = mid - 1;
        } else {
            start = mid + 1;
        }
    }
    bottom_cnt = bottom.size() - b_i;

    return top_cnt+bottom_cnt;
}

void research(int &cnt, int &min_h) {
    for (int layer = 0; layer < h; layer++) {
        faced.push_back(is_faced(layer)); // 층마다 맞는 횟수를 가져옴
    }
    sort(faced.begin(), faced.end());
    min_h = faced[0]; // 정렬 후 가장 작은게 최소 장애물 파괴 수
    for (int k: faced) {
        if (min_h == k) {
            cnt++; // 장애물 파괴 수가 가장 적은 층의 갯수
        }
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int cnt = 0, min_h = 0;

    input();
    sort(top.begin(), top.end());
    sort(bottom.begin(), bottom.end());

    research(cnt, min_h);

    cout << min_h << " " << cnt << '\n'; // 최솟값과 구간 수
    return 0;
}
