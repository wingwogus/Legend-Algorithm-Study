#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int n,m; // 가로 , 세로
vector<vector<int>> city;
vector<vector<bool>> vistied;
int dx[] = {1,0}; // 이동좌표
int dy[] = {0,1};
void input() {
    cin >> n >> m;
    // n이 x m이 y좌표임
    for (int i = 0; i < m; i++) {
        vector<int> temp;
        for (int j = 0; j < n; j++) {
            int road;
            cin >> road;
            temp.push_back(road);
        }
        city.push_back(temp);
        temp.clear(); // 초기화
    }
    vistied.assign(m,vector<bool>(n,false));
}
bool check(int x, int y) {
    if (x >= 0 && y >= 0 && x < m && y < n) {
        // 범위 내에 있고
        if (city[x][y] != 0) {
            // 건물이 아니라면
            return true;
        }
    }
    return false;
}
bool is_exchange(int x, int y) { // 지금 좌표가 거래소 인지
    if (x == m-1 && y == n-1) {
        return true;
    }
    return false;
}
string bfs(int x, int y) {
    queue<pair<int,int>> q;
    q.push({x,y});
    vistied[x][y] = true;
    while (!q.empty()) {
        pair<int,int> cur = q.front();
        int cur_x = cur.first;
        int cur_y = cur.second;
        if (is_exchange(cur_x,cur_y)) {
            return "Yes";
        }
        q.pop(); // 해제
        for (int i = 0; i < 2; i++) {
            int n_x = cur_x + dx[i];
            int n_y = cur_y + dy[i];
            if (check(n_x, n_y) && !vistied[n_x][n_y]) {
                q.push({n_x,n_y}); // q에 저장
                vistied[n_x][n_y] = true; // 방문 처리
            }
        }
    }
    return "No";
}
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    input();

    cout << bfs(0,0) << '\n';

    return 0;
}