import React from "react";

import "./App.css";
import { Route, Routes } from "react-router-dom";
import {
  AUTH_PATH,
  LOCAL_PATH,
  QNA_DETAIL_PATH,
  QNA_PATH,
  QNA_UPDATE_PATH,
  QNA_WRITE_PATH,
  RATIO_PATH,
  SERVICE_PATH,
} from "./constant/Index";

function App() {
  return (
    <Routes>
      <Route path={AUTH_PATH} element={<></>} />
      <Route path={SERVICE_PATH} element={<></>}>
        <Route path={LOCAL_PATH} element={<></>} />
        <Route path={RATIO_PATH} element={<></>} />
        <Route path={QNA_PATH}>
          <Route index element={<></>} />
          <Route path={QNA_WRITE_PATH} element={<></>} />
          <Route path={QNA_DETAIL_PATH} element={<></>} />
          <Route path={QNA_UPDATE_PATH} element={<></>} />
        </Route>
      </Route>
      <Route path="*" element={<></>} />
    </Routes>
  );
}

export default App;

// # - authentication (로그인, 회원가입)
// #- service
// #  - local (지역 평균)
// #  - ratio (비율 계산)
// #  - qna (QnA 리스트)
// #    - write (QnA 작성)
// #    - update/:receptionNumber (QnA 수정)
