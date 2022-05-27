import java.util.*;

public class solutionx {

    // C++ TO JAVA CONVERTER NOTE: The following #define macro was replaced in-line:
    // ORIGINAL LINE: #define vt Vector<int>

    public BTNode root;

    public final pair<Integer, Integer> 
    
    publicshortestRange(BTNode root)
	{
		Vector<Vector<Integer>> v = new Vector<Vector<Integer>>();
		Queue<BTNode> q = new LinkedList<BTNode>();
		q.add(root);
		while (!q.isEmpty())
		{
			int size = q.size();
			Vector<Integer> t = new Vector<Integer>();
			while ((size--) != 0)
			{
				root = q.peek();
				q.remove();
				t.add_back(root.data);
				if (root.left)
				{
				   q.add(root.left);
				}
				if (root.right)
				{
				   q.add(root.right);
				}
			}
			v.add_back(t);
		}
		int m = v.size();
		int mx = 0;
		int s;
		int e;
		int diff = Integer.MAX_VALUE;
		priority_queue<Vector<Integer>,Vector<Vector<Integer>>,greater<Vector<Integer>>> pq = new priority_queue<Vector<Integer>,Vector<Vector<Integer>>,greater<Vector<Integer>>>();
		for (int i = 0;i < m;i++)
		{
			pq.add({v[i][0],i,0});
			mx = Math.max(mx,v[i][0]);
		}
		while (!pq.isEmpty())
		{
			int mn = pq.top()[0];
			int i = pq.top()[1];
			int j = pq.top()[2];
			pq.remove();
			if (mx - mn < diff)
			{
				diff = mx - mn;
				s = mn;
				e = mx;
			}
			j++;
			if (j == v[i].size())
			{
			   break;
			}
			mx = Math.max(mx,v[i][j]);
			pq.add({v[i][j],i,j});
		}
		return new pair<Integer, Integer>(s,e);
	}
}