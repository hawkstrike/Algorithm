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

static DX: [i32; 4] = [-1, 0, 1, 0];
static DY: [i32; 4] = [0, 1, 0, -1];

fn checked(field: &Vec<Vec<i32>>, x: usize, y: usize) -> bool {
    if x >= 0 && y >= 0 && x < field.len() && y < field[0].len() {
        true
    } else {
        false
    }
}

fn bfs(field: &mut Vec<Vec<i32>>, visited: &mut Vec<Vec<bool>>, x: i32, y: i32, number: i32) {
    let mut queue: VecDeque<Coordinate> = VecDeque::new();
    
    queue.push_back(Coordinate::new(x, y));
    visited[x as usize][y as usize] = true;
    field[x as usize][y as usize] = number;
    
    while !queue.is_empty() {
        let coor: Coordinate = queue.pop_front().unwrap();
        
        for index in 0..4 {
            let curr_x: usize = (coor.x + DX[index]) as usize;
            let curr_y: usize = (coor.y + DY[index]) as usize;
            
            if checked(field, curr_x, curr_y) && field[curr_x][curr_y] == 1 && !visited[curr_x][curr_y] {
                field[curr_x][curr_y] = number;
                visited[curr_x][curr_y] = true;
                queue.push_back(Coordinate::new(curr_x as i32, curr_y as i32));
            }
        }
    }
}

pub fn baekjoon_2146() {
    let n: usize = stdin().lines().next().unwrap().unwrap().parse::<usize>().unwrap();
    let mut field: Vec<Vec<i32>> = vec![vec![0; n]; n];
    let mut visited: Vec<Vec<bool>> = vec![vec![false; n]; n];
    let mut min_length = 10000;
    let mut number: i32 = 1;
    
    for index in 0..n {
        let mut line: String = String::new();
        
        stdin().read_line(&mut line).unwrap();
        
        field[index] = line.split_whitespace().map(|s| s.parse::<i32>().unwrap()).collect::<Vec<i32>>();
    }
    
    for i in 0..n {
        for j in 0..n {
            if field[i][j] == 1 && !visited[i][j] {
                bfs(&mut field, &mut visited, i as i32, j as i32, number);
                number += 1;
            }
        }
    }
    
    for i in 0..n {
        for j in 0..n {
            if field[i][j] != 0 {
                for x in 0..n {
                    for y in 0..n {
                        if field[x][y] != 0 && field[i][j] != field[x][y] {
                            min_length = min_length.min((x as i32 - i as i32).abs() + (y as i32 - j as i32).abs() - 1);
                        }
                    }
                }
            }
        }
    }
    
    println!("{}", min_length);
}