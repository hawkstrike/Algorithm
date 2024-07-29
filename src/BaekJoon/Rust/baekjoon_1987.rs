use std::io::stdin;

static mut MAX: i32 = 0;
static DX: [i32; 4] = [-1, 0, 1, 0];
static DY: [i32; 4] = [0, 1, 0, -1];

pub fn baekjoon_1987() {
    let r_c: Vec<usize> = stdin().lines().next().unwrap().unwrap()
        .split_whitespace().map(|s| s.parse::<usize>().unwrap()).collect::<Vec<usize>>();
    let (r, c) = (r_c[0], r_c[1]);
    let mut field: Vec<Vec<char>> = Vec::with_capacity(r);
    let mut visited: Vec<bool> = vec![false; 26];
    
    for i in 0..r {
        let mut line = String::new();
        
        stdin().read_line(&mut line).unwrap();
        
        field.push(line.trim().chars().collect());
    }
    
    unsafe {
        visited[(field[0][0] as u8 - b'A') as usize] = true;
        dfs(&field, &mut visited, 0, 0, 1);
        println!("{}", MAX);
    }
}

unsafe fn dfs(field: &Vec<Vec<char>>, visited: &mut Vec<bool>, x: i32, y: i32, count: i32) {
    if count > MAX {
        MAX = count;
    }
    
    for i in 0..4 {
        let curr_x: i32 = x + DX[i];
        let curr_y: i32 = y + DY[i];
        
        if curr_x >= 0 && curr_y >= 0 && (curr_x as usize) < field.len() && (curr_y as usize) < field[0].len() {
            let here: usize = (field[curr_x as usize][curr_y as usize] as u8 - b'A') as usize;
            
            if !visited[here] {
                visited[here] = true;
                dfs(field, visited, curr_x, curr_y, count + 1);
                visited[here] = false;
            }
        }
    }
}