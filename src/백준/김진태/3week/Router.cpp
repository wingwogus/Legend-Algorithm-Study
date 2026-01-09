#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int binary_research(vector<int>& coordinate);
bool can_install(vector<int> &coordinate, int mid);
int n,c; // 집, 공유기 개수

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> n >> c;

    // 수직선 역할 1차원 벡터
    vector<int> coordinate;
    for (int i = 0; i < n; i++) {
        int x;
        cin >> x;
        coordinate.push_back(x);
    }
    sort(coordinate.begin(), coordinate.end()); // 퀵 + 힙 = 인트로정렬
    // stable_sort -> 값이 같은 원소들의 상대적 순서 유지(누가 먼저 입력됐나)

    cout << binary_research(coordinate) << '\n';

    return 0;
}
int binary_research(vector<int>& coordinate) {
    int dis = 0;
    int start = 1;// 최소거리
    int end = coordinate.back() - coordinate.front();// 최대거리

    while (start <= end) {
        int mid = (start + end) / 2; // 매개변수
        // 배열 인덱스 중간이 아닌 거리의 중간임.
        // 예시의 경우 4 -> 1번째 반복
        if (can_install(coordinate, mid)) {// 이분 탐색
            dis = mid;
            start = mid + 1; // 가운데 기준 오른쪽
        }else {
            end = mid - 1; // 왼쪽
        }
    }
    return dis;
}
bool can_install(vector<int> &coordinate, int mid) {
    int cnt = 1; // 가장 앞에 집에 이미 공유기가 설치 되어 있다고 생각.
    int last_pos = coordinate[0]; // 위와 동일

    for (int i = 1; i < n; i++) { // 2번째 집부터 생각
        int cur_pos = coordinate[i]; // 다음집
        if (cur_pos - last_pos >= mid) {
            cnt++;
            last_pos = cur_pos;
        }
    }
    return cnt >= c;
}