#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

int n, m;
vector<vector<int> > iceberg;
vector<vector<int> > cnt; // 빙산이 녹을 개수를 가진 2차원 벡터
bool division = false;

void input() {
    cin >> n >> m;
    for (int i = 0; i < n; i++) {
        vector<int> row;
        for (int j = 0; j < m; j++) {
            int h;
            cin >> h;
            row.push_back(h);
        }
        iceberg.push_back(row);
    }
    cnt.assign(n, vector<int>(m, 0));
}

bool check_o(int x, int y) {
    if (x >= 0 && y >= 0 && x < n && y < m) {
        // 2차원 벡테 범위내에 있고
        if (iceberg[x][y] == 0) {
            // 그 좌표의 값이 0(바다)이면
            return true;
        }
    }
    return false;
}

void cnt_o(int h, int w) {
    // 자기 주변에 바다가 몇개인지 세기
    int dx[] = {-1, 1, 0, 0};
    int dy[] = {0, 0, -1, 1};
    int o = 0; // 자기 주변 바다 갯수

    for (int i = 0; i < 4; i++) {
        int next_x = h + dx[i]; //좌표
        int next_y = w + dy[i];
        if (check_o(next_x, next_y)) {
            o++;
        }
    }
    cnt[h][w] = o; // 바다 개수 저장
}

void melting() {
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            iceberg[i][j] -= cnt[i][j];
            if (iceberg[i][j] < 0) // 0이하가 될 수 없음
                iceberg[i][j] = 0;
        }
    }
    cnt.assign(n, vector<int>(m, 0)); // 다음 년도를 위해서 초기화
}

int ice_bfs(int h, int w, vector<vector<bool>> &vistied) {
    queue<pair<int, int> > q;
    q.push({h, w});
    vistied[h][w] = true; // 표시

    int dx[] = {-1, 1, 0, 0};
    int dy[] = {0, 0, -1, 1};

    int count = 0; // 연결된 빙산 갯수
    while (!q.empty()) {
        pair<int, int> c = q.front();
        int c_x = c.first;
        int c_y = c.second;
        q.pop();
        for (int i = 0; i < 4; i++) {
            // 좌표 움직여서 찾기
            int n_x = c_x + dx[i];
            int n_y = c_y + dy[i];

            if (!check_o(n_x,n_y) && !vistied[n_x][n_y]) {
                // cnt_o 함수와는 다르게 0이 아닌 놈을 찾는거임
                // 이 안은 0이 아닌 놈들
                q.push({n_x,n_y});
                vistied[n_x][n_y] = true; // 방문처리
                count++; // 연결되어있다는 거니 1증가
            }
        }
    }
    /*
      증가된 count 갯수와 전체에서 0이아닌 것들의 갯수가 같으면 분단되지 않은거고
      count보다 0이아닌 것들의 갯수가 크면 분단이 된거고
      둘 다 아니면 녹을 때까지 분단이 안된거 아닌가
    */
    return count;

}
int check_division() {
    // 빙산이 분리되어있는지
    vector<vector<bool>> vistied(n, vector<bool>(m, false));

    int r = 1;
    int not_zero = 0;

    for(int x=0; x<n; x++){
      for(int y=0; y<m; y++){
        if(iceberg[x][y] != 0){
          not_zero++;
        }
      }
    }
    if(not_zero == 0){
      return 0;
    }
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (iceberg[i][j] != 0 && !vistied[i][j]) {
                r = ice_bfs(i, j, vistied);
                if(r == count) return 1; // 덩어리 하나
                else return 2; // 덩어리 2개이상
            }
        }
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    input();

    int year = 0;

    while (true) {
        int iceberg_cnt = check_division(); // 분리된 빙산의 갯수
        if (iceberg_cnt >= 2) break;
        else if (iceberg_cnt == 0) {
            // 다 녹을 때까지 분리가 안되면
            year = 0;
            break;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (iceberg[i][j] != 0) {
                    // 바다가 아니면
                    cnt_o(i, j);
                }
            }
        }
        // 위 반목 문이 끝나면 cnt 벡터에 빙산 주변에 바다 갯수가 있을 거임.
        // 그다음 할 일은 동시에 빙산 녹는 거 적용
        melting();

        year++; // 연도 수 증가
    }

    cout << year << '\n';
    return 0;
}