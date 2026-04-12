class Solution {
  public:
    void printDiamond(int n) {
        upTriangle(n);
        lowTriangle(n);
    }
    void lowTriangle(int n){
        for(int i =1;i<=n;i++){
            for(int j =1;j<=i-1;j++){
                cout<<" ";
            }
            for(int j =1;j<=n-i+1;j++){
                cout<<"*"<<" ";
            }
            for(int j =1;j<=i-1;j++){
                cout<<" ";
            }
            cout<<endl;
    }
    }
    void upTriangle(int n){
        for(int i =1;i<=n;i++){
            for(int j =1;j<=n-i-1;j++){
                cout<<" ";
            }
            for(int j=1;j<=i;j++){
                cout<<"*"<<" ";
            }
            for(int j=1;j<=n-i-1;j++){
                     cout<<" ";
            }
            cout<<endl;
        }
    }
};