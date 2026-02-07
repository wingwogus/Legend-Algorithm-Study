#include <iostream>
#include <vector>

using namespace std;
int r, c; // 학생의 현재 위치
vector<vector<int> > map;
vector<vector<bool> > visited;
const int dx[] = {1, -1, 0, 0};
const int dy[] = {0, 0, 1, -1};
int min_road = 25;
int cnt = 0;

void dfs(int c, int road, int nx, int ny) {
    // cnt는 먹은 사과의 갯수
    if (c == 3) { // 베이스케이스
        cnt = c;
        if (min_road > road) {
            min_road = road;
            return;
        }
    }
    for (int i = 0; i < 4; i++) {
        int n_x = nx + dx[i];
        int n_y = ny + dy[i];
        if (n_x >= 0 && n_y >= 0 && n_x < 5 && n_y < 5 && map[n_x][n_y] != -1 && !visited[n_x][n_y]) {
            // 범위 내에 있고 장애물도 아니고 처음 가본데면
            if (map[n_x][n_y] == 1) {
                visited[n_x][n_y] = true;
                dfs(c+1, road + 1, n_x, n_y);
                visited[n_x][n_y] = false;
            } else {
                visited[n_x][n_y] = true;
                dfs(c, road + 1, n_x, n_y);
                visited[n_x][n_y] = false;
            }
        }
    }
}

void input() {
    map.assign(5, vector<int>(5, 0));
    visited.assign(5, vector<bool>(5, false));
    for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
            // 맵이 5x5 굉장히 짧아서
            cin >> map[i][j];
            if (map[i][j] == -1) {
                // 이미 방문 했다고 하면 못감.
                visited[i][j] = true;
            }
        }
    }
    cin >> r >> c;
    visited[r][c] = true; // 현재 그 위에 있으니 바로 방문처리
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    input();
    int road = 0;
    dfs(cnt, road, r, c);
    if (cnt < 3) {
        cout << -1 <<'\n';
        return 0;
    } else {
        cout << min_road << '\n';
        return 0;
    }
}
