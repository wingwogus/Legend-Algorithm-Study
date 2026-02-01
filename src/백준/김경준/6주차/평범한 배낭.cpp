#include <iostream>
#include <algorithm>
using namespace std;

int N, K;
int W[101], V[101];
int DP[101][100001];

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> N >> K;
    for (int i = 1; i <= N; i++)
    {
        cin >> W[i] >> V[i];
    }

    for (int i = 1; i <= N; i++)
    {
        for (int j = 1; j <= K; j++)
        {
            if (W[i] <= j) DP[i][j] = max(DP[i - 1][j], DP[i - 1][j - W[i]] + V[i]);
            else DP[i][j] = DP[i - 1][j];
        }
    }

    cout << DP[N][K];
    return 0;
}