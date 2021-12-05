// leetcode 721 Accounts Merge

/*
time: O(NKlogNK) N is the number of accounts and K is the maximum length of an account.
space: O(NK)
*/ 

dfs
class Solution {    
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        // <email node, neighbor nodes>
        Map<String, List<String>> graph = new HashMap<String, List<String>>();
        for (List<String> account : accounts) {
            // Building adjacency list
            // Adding edge between first email to all other emails in the account
            for (int i = 1; i < account.size(); i++) {
                if (!graph.containsKey(account.get(i))) {
                    graph.put(account.get(i), new ArrayList<>());
                }

                if (i == 1) continue;
                graph.get(account.get(i)).add(account.get(i - 1));
                graph.get(account.get(i - 1)).add(account.get(i));
            }
        }
        
        Set<String> visited = new HashSet<>();
        // Traverse over all th accounts to store components
        List<List<String>> res = new ArrayList<>();
        for (List<String> account : accounts) {
            String accountName = account.get(0);
            String accountFirstEmail = account.get(1);
            
            // If email is visited, then it's a part of different component
            // Hence perform dfs only if email is not visited yet
            if (!visited.contains(accountFirstEmail)) {
                List<String> mergedAccount = new ArrayList<>();
                // Adding account name at the 0th index
                mergedAccount.add(accountName);
                
                dfs(graph, visited, mergedAccount, accountFirstEmail);
                Collections.sort(mergedAccount.subList(1, mergedAccount.size())); 
                res.add(mergedAccount);
            }
        }
        
        return res;
    }

    private void dfs(Map<String, List<String>> graph, Set<String> visited, List<String> mergedAccount, String email) {
        visited.add(email);
        // Add the email vector that contains the current component's emails
        mergedAccount.add(email);
        
        if (!graph.containsKey(email)) return;
        
        for (String neighbor : graph.get(email)) {
            if (!visited.contains(neighbor)) {
                dfs(graph, visited, mergedAccount, neighbor);
            }
        }
    }
}