#include <iostream>
#include <vector>
#include <queue> // 표준 라이브러리 사용
#include <algorithm>
using namespace std;

void dfs(int cur, vector<vector<int> >& graph_vec, vector<bool>& visited);
void bfs(int s, vector<vector<int> >& graph_vec, vector<bool>& visited);

static int n, m, v;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> n >> m >> v; // 정점,간선 갯수, 탐색 시잘할 정점의 번호
    // N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000)

    // 이중 벡테 (가변길이)
    vector<vector<int> > graph_vec(n + 1, vector<int>(n + 1, 0));
    vector<bool> visited(n + 1);

    // 인접 행렬로 간선 채우기
    for (int i = 1; i <= m; i++) {
        int vertex1, vertex2;
        cin >> vertex1 >> vertex2;
        graph_vec[vertex1][vertex2] = graph_vec[vertex2][vertex1] = 1;
    }

    dfs(v, graph_vec, visited);
    cout << '\n';
    fill(visited.begin(), visited.end(), 0); // 배열 초기화
    bfs(v,graph_vec,visited);
}


void dfs(int cur, vector<vector<int>>& graph_vec, vector<bool>& visited) {
    if (visited[cur]) {
        return;
    }
    cout << cur << " ";
    visited[cur] = true;
    for (int i = 1; i <= n; i++) {
        if (graph_vec[cur][i] == 1 && !visited[i]) {
            // 간선이 있지만 방문하지 않았다면
            dfs(i, graph_vec, visited);
        }
    }
}

void bfs(int s, vector<vector<int> >& graph_vec, vector<bool>& visited) {
    queue<int> q; // int형 Queue
    // 큐에 넣고 뺴는 형식
    q.push(s); // 시작 노드 넣기
    visited[s] = true; // s 방문
    while (!q.empty()) {
        int cur = q.front(); // 큐 맨앞 가져오기 (처음일 경우 시작노드)
        cout << cur << " "; // 방문 후 바로 출력
        q.pop(); // 삭제
        for (int i = 1; i <= n; i++) {
            if (graph_vec[cur][i] == 1 && !visited[i]) {
                // 간선이 있고 방문하지 않은 노드면 // 번호 작은 순 부터
                q.push(i); // 정점 이동 후 queue에 push
                visited[i] = true; // 방문
            }
        }
    }
}
