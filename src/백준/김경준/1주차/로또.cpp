#include <iostream>
#include <vector>
using namespace std;

int S[13];
int lotto[6];
int k;

void dfs(int start, int depth)
{
    if (depth == 6)
    {
        for (int i = 0; i < 6; i++)
        {
            cout << lotto[i] << " ";
        }
        cout << "\n";
        return;
    }

    // start 부터 k-1까지
    for (int i = start; i < k; i++)
    {
        lotto[depth] = S[i];
        dfs(i+1, depth+1);
    }
}
int main()
{
    while (1)
    {
        cin >> k;
        if (k == 0) break;
        for (int i = 0; i < k; i++)
        {
            cin >> S[i];
        }

        dfs(0, 0);
        cout << "\n";
    }
}