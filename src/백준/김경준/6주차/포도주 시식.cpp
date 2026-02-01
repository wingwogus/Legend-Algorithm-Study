#include <iostream>
#include <algorithm>

using namespace std;

int n;
int wine[10001], dp[10001]; // 포도주 양 , 포도주 양의 최댓값

void dynamic()
{
    dp[0] = 0;
    dp[1] = wine[1];
    dp[2] = wine[1] + wine[2];
    for (int i = 3; i <= n; i++)
    {
        dp[i] = max({ dp[i - 3] + wine[i - 1] + wine[i], dp[i - 2] + wine[i], dp[i - 1] });
    }
}
int main()
{
    cin >> n;
    for (int i = 1; i <= n; i++)
    {
        cin >> wine[i];
    }
    dynamic();
    cout << dp[n];
    return 0;
}