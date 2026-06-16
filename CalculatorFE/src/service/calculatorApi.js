import axios from "axios";

const API_BASE_URL = "http://localhost:8080/api";

export const calculate = async (payload) => {
  const response = await axios.post(
    `${API_BASE_URL}/calculate`,
    payload
  );

  return response.data;
};