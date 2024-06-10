use std::io::stdin;

pub fn baekjoon_1759() {
    let l_c: Vec<usize> = stdin().lines().next().unwrap().unwrap()
        .split_whitespace().map(|s| s.parse::<usize>().unwrap()).collect::<Vec<usize>>();
    let (l, c) = (l_c[0], l_c[1]);
    let mut alphabet_vector: Vec<char> = stdin().lines().next().unwrap().unwrap()
        .split_whitespace().map(|s| s.parse::<char>().unwrap()).collect::<Vec<char>>();
    
    alphabet_vector.sort_unstable();
    
    dfs(&alphabet_vector, "".to_string(), 0, l);
}

fn dfs(arr: &[char], str: String, cnt: usize, l: usize) {
    if str.len() == l {
        if check(&str) {
            println!("{}", str);
        }
        return;
    }

    if cnt >= arr.len() {
        return;
    }

    dfs(arr, format!("{}{}", str, arr[cnt]), cnt + 1, l);
    dfs(arr, str, cnt + 1, l);
}

fn check(str: &str) -> bool {
    let (mut ja, mut mo) = (0, 0);
    for c in str.chars() {
        if ['a', 'e', 'i', 'u', 'o'].contains(&c) {
            mo += 1;
        } else {
            ja += 1;
        }
    }

    mo > 0 && ja > 1
}