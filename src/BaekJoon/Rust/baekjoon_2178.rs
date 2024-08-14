use std::collections::VecDeque;
use std::io::{BufRead, stdin};

struct Coordinate {
    x: i32,
    y: i32,
    count: i32,
}

impl Coordinate {
    fn new(x: i32, y: i32, count: i32) -> Self {
        Self { x, y, count }
    }
}

static DX: [i32; 4] = [-1, 0, 1, 0];
static DY: [i32; 4] = [0, 1, 0, -1];

fn checked(field: &Vec<Vec<i32>>, x: usize, y: usize) -> bool {
    if x >= 0 && y >= 0 && x < field.len() && y < field[0].len() {
        true
    } else {
        false
    }
}

fn bfs(field: &mut Vec<Vec<i32>>, visited: &mut Vec<Vec<bool>>) {
    let mut queue: VecDeque<Coordinate> = VecDeque::new();
    
    queue.push_back(Coordinate::new(0, 0, 1));
    visited[0][0] = true;
    
    while !queue.is_empty() {
        let mut coor: Coordinate = queue.pop_front().unwrap();
        
        if coor.x as usize == field.len() - 1 && coor.y as usize == field[0].len() - 1 {
            println!("{}", coor.count);
            break;
        }
        
        for index in 0..4 {
            let curr_x: usize = (coor.x + DX[index]) as usize;
            let curr_y: usize = (coor.y + DY[index]) as usize;
            
            if checked(field, curr_x, curr_y) && field[curr_x][curr_y] == 1 && !visited[curr_x][curr_y] {
                queue.push_back(Coordinate::new(curr_x as i32, curr_y as i32, coor.count + 1));
                visited[curr_x][curr_y] = true;
            }
        }
    }
}

pub fn baekjoon_2178() {
    let mut lines = stdin().lock().lines().map(|line| line.unwrap());
    let n_m: Vec<usize> = lines.next().unwrap().trim().split_whitespace()
        .map(|s| s.parse::<usize>().unwrap()).collect::<Vec<usize>>();
    let (n, m) = (n_m[0], n_m[1]);
    let mut field: Vec<Vec<i32>> = vec![vec![0; m]; n];
    let mut visited: Vec<Vec<bool>> = vec![vec![false; m]; n];
    
    for index in 0..n {
        field[index] = lines.next().unwrap().chars().map(|c| c.to_digit(10).unwrap() as i32).collect::<Vec<i32>>();
    }
    
    bfs(&mut field, &mut visited);
}