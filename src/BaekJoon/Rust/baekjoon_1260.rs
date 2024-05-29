use std::collections::VecDeque;
use std::io::stdin;

pub fn baekjoon_1260() {
    let mut n_m_v: Vec<usize> = stdin().lines().next().unwrap().unwrap().split_whitespace()
        .map(|s| s.parse::<usize>().unwrap())
        .collect::<Vec<usize>>();
    let (n, mut m, v) = (n_m_v[0], n_m_v[1], n_m_v[2]);
    let mut field: Vec<Vec<i32>> = vec![vec![0; n + 1]; n + 1];
    
    while m > 0 {
        m -= 1;
        
        let x_y: Vec<usize> = stdin().lines().next().unwrap().unwrap().split_whitespace()
            .map(|s| s.parse::<usize>().unwrap())
            .collect::<Vec<usize>>();
        let (x, y) = (x_y[0], x_y[1]);
        
        field[x][y] = 1;
        field[y][x] = 1;
    }
    
    dfs(&field, n, v);
    bfs(&field, n, v);
}

fn dfs(field: &Vec<Vec<i32>>, n: usize, v: usize) {
    let mut stack: Vec<usize> = Vec::new();
    let mut result: Vec<usize> = Vec::new();
    let mut checked: Vec<bool> = vec![false; n + 1];
    
    stack.push(v);
    result.push(v);
    checked[v] = true;
    
    while !stack.is_empty() {
        let current = stack.last().unwrap();
        let mut flag: bool = false;
        
        for index in 1..field.len() {
            if field[*current][index] == 1 && !checked[index] {
                checked[index] = true;
                stack.push(index);
                result.push(index);
                flag = true;
                
                break;
            }
        }
        
        if !flag {
            stack.pop();
        }
    }
    
    
    for value in result.iter() {
        print!("{} ", value);
    }
    println!();
}

fn bfs(field: &Vec<Vec<i32>>, n: usize, v: usize) {
    let mut queue: VecDeque<usize> = VecDeque::new();
    let mut result: Vec<usize> = Vec::new();
    let mut checked: Vec<bool> = vec![false; n + 1];
    
    queue.push_back(v);
    result.push(v);
    checked[v] = true;
    
    while !queue.is_empty() {
        let current = queue.pop_front().unwrap();
        
        for index in 1..field.len() {
            if field[current][index] == 1 && !checked[index] {
                checked[index] = true;
                queue.push_back(index);
                result.push(index);
            }
        }
    }
    
    for value in result.iter() {
        print!("{} ", value);
    }
    println!();
}