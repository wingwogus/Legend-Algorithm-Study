#include <iostream>
#include <algorithm>
using namespace std;

int N;
int Pack[10001];
int DP[10001];

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> N;
    for (int i = 1; i <= N; i++)
    {
        cin >> Pack[i];
    }

    DP[1] = Pack[1];
    for (int i = 2; i <= N; i++)
    {
        for (int j = 1; j <= i; j++)
        {
            DP[i] = max(DP[i], DP[i - j] + Pack[j]); // 지금까지 최대값 vs 새로 계산한 값
        }
    }

    cout << DP[N];
    return 0;
}