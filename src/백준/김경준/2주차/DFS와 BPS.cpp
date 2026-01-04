#include <iostream>
#include <queue> // BFS를 위한 큐 라이브러리
#include <string.h> // memset 사용을 위한 라이브러리
using namespace std;

int arr[1001][1001]; // 인접행렬
bool visited[1001];
queue<int> q; // 큐 생성
int N, M, V;

void DFS(int V)
{
    visited[V] = true; // 시작점 방문기록
    cout << V << " "; // 방문한 노드 출력

    for (int i = 1; i <= N; i++)
    {
        if (arr[V][i] == 1 && visited[i] == false) // 현재 정점과 연결되어있고 방문하지 않았다면
        {
            DFS(i); // 스택에 i 넣기
        }
        if (i == N)
            return;
    }
}

void BFS(int V)
{
    q.push(V); // 시작노드 큐에 넣음
    visited[V] = true; // 방문기록
    cout << V << " ";

    while (!q.empty())
    {
        V = q.front(); // 큐 맨 앞에 값을 방문
        q.pop(); // 큐에서 빼기

        // 방문했던 노드와 가까운 노드 큐에 넣어줌
        for (int i = 1; i <= N; i++)
        {
            if (arr[V][i] == 1 && visited[i] == false) // 현재 정점과 연결되어있고 방문하지 않았다면
            {
                q.push(i); // 큐에 넣기
                visited[i] = true; // i 점은 미리 방문기록 - 안하면 중복으로 방문할 수도 있다
                cout << i << " ";
            }
        }
    }
}

int main()
{
    int u, v;
    cin >> N >> M >> V;

    for (int i = 0; i < M; i++)
    {
        cin >> u >> v;
        arr[u][v] = 1;
        arr[v][u] = 1; // 양방향 처리
    }

    DFS(V);

    cout << "\n";
    memset(visited, 0, sizeof(visited)); // visited 초기화

    BFS(V);

    return 0;
}
