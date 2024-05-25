use std::collections::VecDeque;
use std::io::stdin;

struct Coordinate {
    x: i32,
    y: i32,
}

impl Coordinate {
    fn new(x: i32, y: i32) -> Self {
        Self { x, y }
    }
    
}

fn checked(field: &Vec<Vec<i32>>, x: usize, y: usize) -> bool {
    if x > 0 && y > 0 && x < field.len() - 1 && y < field[0].len() - 1 {
        true
    } else {
        false
    }
}

fn bfs(field: &Vec<Vec<i32>>, visited: &mut Vec<Vec<bool>>, x: i32, y: i32) {
    let mut queue: VecDeque<Coordinate> = VecDeque::new();
    const DX: [i32; 4] = [-1, 0, 1, 0];
    const DY: [i32; 4] = [0, 1, 0, -1];
    
    queue.push_back(Coordinate::new(x, y));
    
    while !queue.is_empty() {
        let c: Coordinate = queue.pop_front().unwrap();
        
        for index in 0..4 {
            let curr_x: usize = (c.x + DX[index]) as usize;
            let curr_y: usize = (c.y + DY[index]) as usize;
            
            if checked(field, curr_x, curr_y) && field[curr_x][curr_y] == 1 && !visited[curr_x][curr_y] {
                visited[curr_x][curr_y] = true;
                queue.push_back(Coordinate::new(curr_x as i32, curr_y as i32));
            }
        }
    }
}

pub fn baekjoon_1012() {
    let mut test_case: usize = stdin().lines().next().unwrap().unwrap().trim().parse::<usize>().unwrap();
    
    for index in 0..test_case {
        let mut line: String = String::new();
        let mut count: i32 = 0;
        
        stdin().read_line(&mut line).unwrap();
        
        let m_n_k: Vec<usize> = line.split_whitespace().map(|s| s.parse::<usize>().unwrap()).collect();
        let (m, n, k) = (m_n_k[0], m_n_k[1], m_n_k[2]);
        
        let mut field: Vec<Vec<i32>> = vec![vec![0; n + 2]; m + 2];
        let mut visited: Vec<Vec<bool>> = vec![vec![false; n + 2]; m + 2];
        
        for j in 0..k {
            let mut sub_line: String = String::new();
            stdin().read_line(&mut sub_line).unwrap();
            
            let x_y: Vec<usize> = sub_line.split_whitespace().map(|s| s.parse::<usize>().unwrap()).collect();
            let (x, y) = (x_y[0], x_y[1]);
            
            
            field[x + 1][y + 1] = 1;
        }
        
        for field_x in 1..field.len() - 1 {
            for field_y in 1..field[field_x].len() - 1 {
                if field[field_x][field_y] == 1 && !visited[field_x][field_y] {
                    bfs(&field, &mut visited, field_x as i32, field_y as i32);
                    count += 1;
                }
            }
        }
        
        println!("{}", count);
    }
}