#include <iostream>
using namespace std;

int D, K;
int F[33];

void Fibona()
{
    F[1] = 1;
    F[2] = 1;
    for (int i = 3; i <= D; i++)
    {
        F[i] = F[i - 1] + F[i - 2];
    }
}

int main()
{
    cin >> D >> K;

    Fibona();

    int A = 0;
    for (int B = 1; B <= 100000; B++)
    {
        if ((K - F[D - 1] * B) % F[D - 2] == 0)
        {
            A = (K - F[D - 1] * B) / F[D - 2];

            if (A <= B)
            {
                cout << A << "\n" << B;
                return 0;
            }
        }
    }
}